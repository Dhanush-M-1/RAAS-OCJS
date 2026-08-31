#include <iostream>
#include <algorithm>
#include <string>
#define rep(i,n) for(int i=0;i<n;i++)
using namespace std;

int main(){
	int n;
	while(cin>>n and n>0){
		string s[n]; rep(i,n) cin>>s[i];
		int cnt=0;
		rep(i,n-1){
			if(s[i]=="lu" and s[i+1]=="ru") cnt++;
			if(s[i]=="ru" and s[i+1]=="lu") cnt++;
			if(s[i]=="ld" and s[i+1]=="rd") cnt++;
			if(s[i]=="rd" and s[i+1]=="ld") cnt++;
		}
		cout<<cnt<<endl;
	}
	return 0;
}

