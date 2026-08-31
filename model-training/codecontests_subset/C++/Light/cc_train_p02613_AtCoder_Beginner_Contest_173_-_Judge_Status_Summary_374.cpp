#include <bits/stdc++.h>
using namespace std;int main(){int N;map<string,int> m;cin>>N;string s;while(cin>>s)m[s]++;for(auto s:{"AC","WA","TLE","RE"})cout<<s<<" x "<<m[s]<<"\n";}
