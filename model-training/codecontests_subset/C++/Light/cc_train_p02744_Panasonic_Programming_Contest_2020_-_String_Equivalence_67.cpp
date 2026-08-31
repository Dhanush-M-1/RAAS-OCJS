#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
int N;
void solve(int n,int m,string s){
	if(n==0)cout<<s<<endl;
	else{
		for(int i=0;i<m;i++){
			solve(n-1,m,s+(char)('a'+i));
		}
		solve(n-1,m,s+(char)('a'+m));
		if(N>n)solve(n-1,m+1,s+(char)('a'+m+1));
	}
}
int main(){
	cin>>N;
	solve(N,0,"");
	return 0;
}