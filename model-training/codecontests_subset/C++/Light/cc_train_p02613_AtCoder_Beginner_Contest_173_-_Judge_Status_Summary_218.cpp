#include<bits/stdc++.h>
using namespace std;
#define int long long
signed main(){
    int n;
    cin>>n;
    unordered_map<string, int> m;
    while(n--){
        string s;
        cin>>s;
        m[s]++;

    }
    cout<<"AC x "<<m["AC"]<<endl<<"WA x "<<m["WA"]<<endl<<
"TLE x "<<m["TLE"]<<endl<<
"RE x "<<m["RE"]<<endl;

}
