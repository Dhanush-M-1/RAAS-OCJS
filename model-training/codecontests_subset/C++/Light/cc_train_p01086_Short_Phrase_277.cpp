#include<iostream>
#include<vector>
#include<string>
using namespace std;

#define FOR(k,m,n) for(int (k)=(m);(k)<(n);(k)++)
#define rep(i,n) FOR((i),0,(n))

typedef long long ll;

const int INF=1e9+7;
const int MAX_N=1e2;
int data[MAX_N];
int s[5]={5,7,5,7,7};
int main(){
	int n;
	while(cin>>n && n){
		fill(data,data+MAX_N,0);
		rep(i,n){
			string str;
			cin>>str;
			data[i]=str.size();
		}
		int ans=0;
		rep(i,n){
			if(ans!=0)break;
			int k=0;
			rep(j,5){
				int tmp=0;
				while(tmp<s[j] && i+k<n){
					tmp+=data[i+k++];
				}
				if(tmp!=s[j])break;
				if(j==4)ans=i+1;
			}
		}
		cout<<ans<<endl;
	}
}