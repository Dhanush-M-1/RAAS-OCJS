#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for(int i=0;i<int(n);++i)

int main(void){
    int n;
    while(cin>>n, n){
        bool on = false, l = false, r = false;
        int cnt = 0;
        rep(i,n){
            string s;
            cin>>s;
            if(s[0]=='l') l^=true;
            if(s[0]=='r') r^=true;
            if(l == r && on^l){
                on^=true;
                cnt++;
            }
        }
        cout<<cnt<<endl;
    }
}

