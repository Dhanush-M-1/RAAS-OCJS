#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;i++)
#define REP(i,a,b) for(int i=a;i<=b;i++)
using namespace std;
int main(){
	while(1){
		int n;
		cin>>n;
		if(!n)break;
		string w[n];
		rep(i,n)cin>>w[i];
		int a[]={5,7,5,7,7};
		int c,s;
		rep(i,n){
			c=s=0;
			REP(j,i,n){
				s+=w[j].length();
				if(s>a[c])break;
				if(s==a[c]){
					s=0;
					c++;
				}
				if(c==5){
					cout<<i+1<<endl;
					goto END;
				}
			}
		}
		END:;
	}
	return 0;
}
