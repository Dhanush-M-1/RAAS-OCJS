#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
typedef pair<int,int> pii;
#define rep(i,n) for(ll i=0;i<(ll)(n);i++)
#define all(a)  (a).begin(),(a).end()
#define pb push_back
#define INF (1e9+1)
//#define INF (1LL<<59)

int main(){
	int n;
	while(cin>>n&&n){
		vector<int> v(n);
		rep(i,n){
			string s;
			cin>>s;
			v[i] = s.size();
		}
		
		rep(i,n){
			int now;
			int pos = i;
			
			int p[]={5,7,5,7,7};
			rep(j,5){
				now=0;
				while(now<p[j]){
					now+=v[pos++];
					if(now==p[j])break;
					if(now>p[j])goto next;
				}
			}
			cout<<i+1<<endl;
			break;
next:;
		}
	}
}