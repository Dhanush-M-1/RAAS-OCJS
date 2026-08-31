#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
#include <map>
#include <set>
#include <cstdio>
#include <cmath>
#define rep(i,l,n) for(lint i=l;i<n;i++)
#define rer(i,l,n) for(lint i=l;i<=n;i++)
#define all(a) a.begin(),a.end()
#define o(a) cout<<a<<endl
#define pb(a) push_back(a)
#define mk(a,b) make_pair(a,b)
#define fi first
#define se second
using namespace std;
typedef long long lint;
typedef vector<int> vi;
typedef vector<lint> vli;
typedef vector<vi> vvi;
typedef pair<int,int> pii;

int main(){
	while(1){
		int n;
		cin>>n;
		if(n==0) break;
		vi d(n);
		rep(i,0,n) cin>>d[i];
		int ans=0,i=0;
		bool f=1;
		while(f){
			f=0;
			for(int j=n-1;j>i;j--){
				if(d[j]<d[j-1]){
					swap(d[j],d[j-1]);
					f=1;
					ans++;
				}
			}
			i++;
		}
		o(ans);
	}
}