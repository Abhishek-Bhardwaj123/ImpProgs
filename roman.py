# Input: 0<num<4000

def intToRoman(num):
    roman_symbols = {
        1: "I",
        5: "V",
        10: "X",
        50: "L",
        100: "C",
        500: "D",
        1000: "M"
    }
    exceptions = {
        0: "",
        4: "IV",
        9: "IX",
        40: "XL",
        90: "XC",
        400: "CD",
        900: "CM"
    }
    power = 10**0
    ans = str()
    while num:
        rem = (num%10)*power
        if rem in roman_symbols:
           ans = f"{roman_symbols[rem]}{ans}"
        elif rem in exceptions:
            ans = f"{exceptions[rem]}{ans}"
        else:
            keys = list(roman_symbols.keys())
            s = str()
            for i in keys[::-1]:
                temp = rem//i
                rem%=i
                s = f"{s}{roman_symbols.get(i, '')*temp}"
            ans = f"{s}{ans}"
        power*=10
        num//=10
    return ans

def romanToInt(s):
    roman_symbols = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }
    num = roman_symbols.get(s[-1])
    prev = num
    for i in s[-2::-1]:
        val = roman_symbols.get(i)
        if val<prev:
            num-=val
        else:
            num+=val
        prev = val
    return num

num = int(input())
s = intToRoman(num)
print(s)
num = romanToInt(s)
print(num)