#include <bits/stdc++.h>
#define rep(i, n) for (int i = 0; i < (int)(n); i++)
using namespace std;

int main(){
int N;
cin>>N;
map<string,int> cnt;
rep(i,N){
    string S;
    cin>>S;
    cnt[S]++;
}
for(string S : {"AC","WA","TLE","RE"}){
    cout<<S<<" x "<<cnt[S]<<endl;
}
return 0;
}