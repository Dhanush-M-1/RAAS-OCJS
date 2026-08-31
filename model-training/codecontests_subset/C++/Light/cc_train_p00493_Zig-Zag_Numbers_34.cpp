#include<iostream>
#include<cstdio>
#include<string>
using namespace std;
string A,B;
int M;
int dp[2][3][10][501][501];
int mod=10000;
int solve(string S,int f,int x,int pre,int rem,int index){
	if(index==S.length()){
		return !rem;
	}
	if(dp[f][x][pre][rem][index]!=-1)return dp[f][x][pre][rem][index];
	int end;
	if(f)end=9;
	else end=S[index]-'0';
	int res=0;
	for(int u=0;u<=end;u++){
		int nextx;
		if(x==0){
			if(pre!=0&&pre==u)continue;
			if(pre==0)nextx=0;
			else if(pre>u)nextx=1;
			else nextx=2;
		}
		else if(x==1){
			if(pre>=u)continue;
			nextx=2;
		}
		else{
			if(pre<=u)continue;
			nextx=1;
		}
		res+=solve(S,f|(u!=(S[index]-'0')),nextx,u,(rem*10+u)%M,index+1);
	}
	res%=mod;

	return dp[f][x][pre][rem][index]=res;
}
string ff(string S){
	int pos=S.length()-1;
	while(S[pos]=='0'){
		S[pos]='9';
		pos--;
	}
	S[pos]=(S[pos]-'0')-1+'0';
	if(pos==0&&S[pos]=='0')S.erase(S.begin());
	return S;
}
int main()
{
	for(int i=0;i<3;i++)for(int j=0;j<10;j++)for(int k=0;k<501;k++)for(int l=0;l<501;l++)for(int m=0;m<2;m++)dp[m][i][j][k][l]=-1;
	cin >> A >> B;scanf("%d",&M);
	A=ff(A);
	int ans1=solve(A,0,0,0,0,0);
	for(int i=0;i<3;i++)for(int j=0;j<10;j++)for(int k=0;k<501;k++)for(int l=0;l<501;l++)for(int m=0;m<2;m++)dp[m][i][j][k][l]=-1;
	int ans2=solve(B,0,0,0,0,0);
	printf("%d\n",(ans2-ans1+mod)%mod);
	return 0;
}