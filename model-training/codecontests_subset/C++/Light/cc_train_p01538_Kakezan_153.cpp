#include<bits/stdc++.h>
using namespace std;

#define REP(i,n) for(int i=0;i<(n);i++)
#define ALL(v) (v).begin(),(v).end()
#define int long long
typedef pair<int,int> P;

//-----------------------------------------------------------------------
int calc(int a){
    string s=to_string(a);
    int res=0;
    for(int i=1;i<s.size();i++){
        int t=stoi(s.substr(0,i))*stoi(s.substr(i));
        res=max(res,t);
    }
    return res;
}

signed main()
{
    cin.tie(0);
    ios::sync_with_stdio(false);

    int n; cin>>n;
    REP(i,n){
        int a; cin>>a;
        int cnt=0;
        while(10<=a){
            a=calc(a);
            cnt++;
        }
        cout<<cnt<<endl;
    }
}


