#include<iostream>
using namespace std;
const int MOD = 1000000007;
int N,M,A,ans[100001];
bool a[100001]={0};

int solve(int n){
	if(n<0||a[n])return 0;
	if(ans[n]==-1)ans[n]=(solve(n-1)+solve(n-2))%MOD;
	return ans[n];
}
int main(){
	cin>>N>>M;
	for(int i=0;i<M;i++){cin>>A;a[A]=true;}
	fill(ans,ans+N+1,-1);
	ans[0]=1;
	cout<<solve(N);
	return 0;
}