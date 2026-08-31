#include<bits/stdc++.h>
using namespace std;

#define REP(i,n) for(int i=0;i<(n);i++)
#define ALL(v) (v).begin(),(v).end()
#define int long long
typedef pair<int,int> P;

//-----------------------------------------------------------------------
int calc(int a){
    int res=0,k=10;
    REP(i,6){
        res=max(res,(a/k)*(a%k));
        k*=10;
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
