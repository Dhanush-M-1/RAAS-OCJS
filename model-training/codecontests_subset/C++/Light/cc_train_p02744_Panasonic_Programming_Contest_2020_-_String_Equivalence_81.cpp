#include <bits/stdc++.h>
using namespace std;

void f(string s,char b,int n){
    if(n==0){cout << s << endl; return;}
    for(char i='a';i<=b+1;i++){
        int m=max(i,b);
        f(s+i,m,n-1);
    }
}

int main(){
    int n; cin >> n;
    f("a",'a',n-1);
    return 0;
}