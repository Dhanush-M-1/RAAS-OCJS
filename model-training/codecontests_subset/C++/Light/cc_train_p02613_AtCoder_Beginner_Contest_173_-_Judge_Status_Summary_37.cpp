#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,a=0,b=0,c=0,d=0;
    cin >> n;
    while(n--){
        string s;
        cin >> s;
        s=="AC"?a++:s=="WA"?b++:s=="TLE"?c++:s=="RE"?d++:0;
    }
    cout << "AC x " << a << "\nWA x " << b << "\nTLE x " << c << "\nRE x " << d;
    return 0;
}