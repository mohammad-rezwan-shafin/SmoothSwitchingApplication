SH_LINE_PREFIX="\x1B[96m $0 :: \x1B[0m"
COLOR_CLEAR="\x1B[0m"
COLOR_ERROR="\x1B[91m"
COLOR_SUCCESS="\x1B[92m"
COLOR_WARN="\x1B[93m"
COLOR_INFO="\x1B[94m"
TMP_ERR_OUT="/vagrant/tmp_err_out"


# $1 = source text, $2 = dest text, $3 = file name
function replace_text_in_file() {
    sudo sed -i -e "s/$1/$2/g" $3 2> $TMP_ERR_OUT
    tmp_out=`cat $TMP_ERR_OUT`
    echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
    rm -f $TMP_ERR_OUT
}

function printlnC() {
    echo -e "$SH_LINE_PREFIX $1 $2 $COLOR_CLEAR"
}

# $1 = target_file, $2 = search_text, $3 = append_line
function test_content_and_append_to_file() {
    output_str=`cat $1 | grep -i $2`
    if [ -z "$output_str" ];then
        printlnC $COLOR_WARN "$2 not found in $1."
        printlnC $COLOR_INFO "Appending $3 ........"
        echo -e "$COLOR_ERROR"
        echo "$3" >> $1 
        echo -e "$COLOR_CLEAR"        
    else
        printlnC $COLOR_INFO "$2 found in $1."        
    fi
}
