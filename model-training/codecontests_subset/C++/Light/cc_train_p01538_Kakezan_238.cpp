#include <bits/stdc++.h>
#define REP(i,n,N) for(int i=n;i<N;i++)
#define p(S) cout<<S<<endl
using namespace std;


int main(){
	int Q;
	while(cin>>Q){
		int N;
		REP(k,0,Q){
			int ans=0;
			set<int> s;
			cin>>N;
			while(N/10>0){
				int mx=0;
				int waru=10;
				s.insert(N);
				for(int i=0;N/waru>0;i++){
					int l=N/waru;
					int r=N%waru;
					mx=max(mx,l*r);
					waru*=10;
				}
				N=mx;
				ans++;
				if(s.find(N)!=s.end()){
					ans=-1;
					break;
				}
			}
			p(ans);
		}
	}

	return 0;
}