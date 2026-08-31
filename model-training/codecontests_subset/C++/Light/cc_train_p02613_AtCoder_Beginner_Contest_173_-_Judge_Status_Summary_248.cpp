#include<bits/stdc++.h>
using namespace std;
int main()
{
    string a;
    int n;
    cin>>n;
    map<string,int> m;
    vector<string> v={"AC","WA","TLE","RE"};
    while(n--)
    {
        cin>>a;
        m[a]++;
    }
    for(auto j:v)
    {
        cout<<j<<" "<<"x"<<" "<<m[j]<<'\n';
    }
}