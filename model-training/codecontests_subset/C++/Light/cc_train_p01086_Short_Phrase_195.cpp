#include <bits/stdc++.h>
#define REP(i,n,N) for(int i=n;i<N;i++)
#define p(S) cout<<S<<endl
using namespace std;


int main(){
	int tnk[5]={5,7,5,7,7};
	int n;
	while(cin>>n,n){
		string s[40];
		int snum=0,now=0,ans=1;
		REP(i,0,n){
			cin>>s[i];
		}
		int j=0;
		while(1){
			snum+=s[j].size();
			j++;
			if(snum==tnk[now]){
				snum=0;
				now++;
			}else if(snum>tnk[now]){
				snum=0;
				now=0;
				j=ans;
				ans++;
			}
			if(now==5){
				p(ans);
				break;
			}

		}
	}
	return 0;
}