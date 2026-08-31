#include<iostream>
#include<cstdio>
#include<string>
using namespace std;

int dp[2][12][502][502]={0};
int m;

char min(char x,char y){if(x>y)return y; return x;}
char max(char x,char y){if(x<y)return y; return x;}

int count(string s){
	int ret=0;
	int ss=s.size();
	if(ss==1)return s[0]/3;
	for(int i=1;i<ss;i++){
		for(int j=1;j<10;j++){
			ret+=dp[0][j][i][0];
			if(i!=1)ret+=dp[1][j][i][0];
			ret%=10000;
		}
	}
	for(int i=1;i<s[0];i++){
		ret+=dp[0][i][ss][0];
		ret+=dp[1][i][ss][0];
		ret%=10000;
	}
	int p[502]={0};
	int tt[502]={0};
	tt[0]=1;
	for(int i=1;i<502;i++){tt[i]=tt[i-1]*10; tt[i]%=m;}
	p[0]=s[0]*tt[ss-1];
	p[0]%=m;
	for(int i=1;i<502;i++){
		p[i]=p[i-1]+s[i]*tt[ss-1-i];
		p[i]%=m;
	}
	for(int i=1;i<ss;i++){
		int t=(i+0)%2;
		if(t==1){
			if(s[i-1]>=s[i])break;
			for(int j=s[i-1]+1;j<s[i];j++){
				ret+=dp[t][j][ss-i][(m-p[i-1])%m];
				ret%=10000;
			}
			if(i==ss-1)ret+=dp[t][s[i]][ss-i][(m-p[i-1])%m];
		}
		if(t==0){
			for(int j=0;j<min(s[i-1],s[i]);j++){
				ret+=dp[t][j][ss-i][(m-p[i-1])%m];
				ret%=10000;
			}
			if(s[i-1]<=s[i])break;
			if(i==ss-1)ret+=dp[t][s[i]][ss-i][(m-p[i-1])%m];
		}
	}
	for(int i=1;i<ss;i++){
		int t=(i+1)%2;
		if(t==1){
			if(s[i-1]>=s[i])break;
			for(int j=s[i-1]+1;j<s[i];j++){
				ret+=dp[t][j][ss-i][(m-p[i-1])%m];
				ret%=10000;
			}
			if(i==ss-1)ret+=dp[t][s[i]][ss-i][(m-p[i-1])%m];
		}
		if(t==0){
			for(int j=0;j<min(s[i-1],s[i]);j++){
				ret+=dp[t][j][ss-i][(m-p[i-1])%m];
				ret%=10000;
			}
			if(s[i-1]<=s[i])break;
			if(i==ss-1)ret+=dp[t][s[i]][ss-i][(m-p[i-1])%m];
		}
	}
	return ret;
}

string f(string s){
	int ss=s.size();
	int k=ss-1;
	while(s[k]==0){
		s[k]=9;
		k--;
	}
	s[k]--;
	if(k==0&&s[k]==0){
		string ret="";
		char c='9'-48;
		for(int i=0;i<ss-1;i++)ret+=c;
		return ret;
	}
	return s;
}			

int main(){
	string a,b;
	cin>>a;
	cin>>b;
	int sa=a.size(),sb=b.size();
	for(int i=0;i<sa;i++)a[i]-=48;
	for(int i=0;i<sb;i++)b[i]-=48;
	scanf("%d",&m);
	dp[0][0][0][0]=1; dp[1][10][0][0]=1; //dp[0][0][1][0]=1;
	int s=max(sa,sb);
	int t=1;
	for(int j=1;j<=s;j++){
		for(int i=0;i<=9;i++){
			for(int k=0;k<m;k++){
				for(int l=i+1;l<=10;l++){
					dp[0][i][j][k]+=dp[1][l][j-1][(k-i*t+i*m)%m];
					dp[0][i][j][k]%=10000;
				}
			}
		}
		for(int i=0;i<=9;i++){
			for(int k=0;k<m;k++){
				for(int l=0;l<i;l++){
					dp[1][i][j][k]+=dp[0][l][j-1][(k-i*t+i*m)%m];
					dp[1][i][j][k]%=10000;
				}
			}
		}
		t*=10;
		t%=m;
	}
	a=f(a); 
	printf("%d\n",(count(b)-count(a)+10000)%10000);
}