function makeChild(boolean stone, boolean value) returns (boolean) {
    boolean result = false;
    // stone and valuable
    if (stone && value) {
        result = true;
        // same as above
    } else if (value && stone) {
        result = true;
    } else if (value || !stone) {
        result =  false;
        // not stone or valuable
    } else if (!stone || !value) {
        result =  false;
    } else if (stone || !value) {
        result =  false;
    }
    return result;
}

function multiBinaryANDExpression(boolean one, boolean two, boolean three) returns (boolean) {
    return one && two && three;
}

function multiBinaryORExpression(boolean one, boolean two, boolean three) returns (boolean) {
    return one || two || three;
}

function multiBinaryExpression(boolean one, boolean two, boolean three) returns (boolean) {
    return (!one || (two && three)) || (!three || (one && two));
}

function bitwiseAnd(int a, int b, byte c, byte d) returns [int, byte, byte, byte] {
    [int, byte, byte, byte] res = [0, 0, 0, 0];
    res[0] = a & b;
    res [1] = a & c;
    res [2] = c & d;
    res [3] = b & d;
    return res;
}

function binaryAndWithQuery() {
    int? i = 3;
    boolean result = i is int && (from var _ in [1, 2]
        where i + 2 == 5
        select 2) == [2, 2];
    assertTrue(result);
}

function binaryOrWithQuery() {
    int? i = 3;
    boolean result = i is () || (from var _ in [1, 2]
        where i + 2 == 5
        select 2) == [2, 2];
    assertTrue(result);
}

function assertTrue(boolean actual) {
    if actual {
        return;
    }
    panic error(string `expected 'true', found '${actual.toString()}'`);
}
