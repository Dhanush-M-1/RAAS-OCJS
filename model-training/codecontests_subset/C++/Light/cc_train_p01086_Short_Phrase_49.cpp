#include<bits/stdc++.h>
using namespace std;

#define REP(i,n) for(int i=0;i<(n);i++)
#define ALL(v) (v).begin(),(v).end()
#define int long long
typedef pair<int,int> P;

//-----------------------------------------------------------------------

signed main()
{
    cin.tie(0);
    ios::sync_with_stdio(false);

    int n;
    while(cin>>n,n){
        vector<int> v(n);
        REP(i,n){
            string s; cin>>s;
            v[i]=s.size();
        }

        REP(i,n){
            int pos=i;
            int j,A[]={5,7,5,7,7};
            for(j=0;j<5;j++){
                int cnt=0;
                while(pos<n && cnt<A[j]) cnt+=v[pos++];
                if(cnt!=A[j]) break;
            }
            if(j==5){
                cout<<i+1<<endl; break;
            }
        }
    }
}

