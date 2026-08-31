#include<bits/stdc++.h>
using namespace std;
map<string,int>m;
string ss[]={"AC", "WA", "TLE", "RE"};
int main()
{
    int n;
    cin>>n;
    while(n--){
        string s;
        cin>>s;
        m[s]++;
    }

    for(auto x:ss){
        cout<<x<<" x "<<m[x]<<endl;
    }
    return 0;
}

