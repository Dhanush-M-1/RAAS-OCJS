#include<iostream>
#include<vector>
#include<string>
using namespace std;
 
#define FOR(i,a,b) for (int i=(a);i<(b);i++)
#define REP(i,n) for (int i=0;i<(n);i++)
 
typedef long long ll;

int main(){
	int N,M;
	cin>>N>>M;
	ll a[N],b[N];
	ll c[M],d[M];
	REP(i,N)cin>>a[i]>>b[i];
	REP(i,M)cin>>c[i]>>d[i];
	REP(i,N){
		ll dist = 1e9;
		int id = -1;
		REP(j,M){
			if(dist>abs(a[i]-c[j])+abs(b[i]-d[j])){
				dist = abs(a[i]-c[j])+abs(b[i]-d[j]);
				id = j;
			}
		}
		cout<<id+1<<endl;
	}
}