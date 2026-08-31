#include <bits/stdc++.h>

using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define REP(i,a) FOR(i,0,a)

const int MAX_N=100;

int N;
int a[MAX_N];

int main(){
	cin.tie(0);
	ios::sync_with_stdio(false);
	do{
		cin>>N;
		if (N){
			REP(i,N){
				cin>>a[i];
			}
			int ans=0;
			REP(i,N){
				REP(j,N-i-1){
					if (a[j]>a[j+1]){
						ans++;
						swap(a[j],a[j+1]);
					}
				}
			}
			cout<<ans<<endl;
		}
	}while (N);
	return 0;
}