#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <map>
#include <list>
#include <set>
#include <numeric>
#include <queue>
#include <stack>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cctype>
#include <cstring>
#include <climits>
#include <cfloat>
#include <ctime>
#include <complex>
#include <cassert>
#include <iomanip>
using namespace std;
typedef long long LL;
typedef pair<int,int> P;

int M;
int dp[2][2][2][10][500]={};
int num(string s, int rem){
	memset(dp,0,sizeof(dp));
	auto cur=dp[0];
	auto nex=dp[1];
	int order=10%M;
	for(int k=0;k<10;k++){
		cur[0][0][k][k%M]=cur[1][0][k][k%M]=1;
		if(k<=s[0]-'0'){
			cur[0][1][k][k%M]=cur[1][1][k][k%M]=1;
		}
	}
	int ret=0;
	ret/=2;
	ret%=10000;
	for(int i=1;i<s.size();i++){
		for(int k=1;k<10;k++){
			//cout << k << ": " << cur[0][0][k][0] << ", " << cur[1][0][k][0] << endl;
			ret+=cur[0][0][k][rem]+cur[1][0][k][rem];
		}
		if(i==1){
			ret/=2;
		}
		//cout << i << ", " << ret << endl;
		ret%=10000;
		for(int r=0;r<M;r++){
			for(int k=1;k<10;k++){
				cur[0][0][k][r]+=cur[0][0][k-1][r];
				cur[0][0][k][r]%=10000;
				cur[0][1][k][r]+=cur[0][1][k-1][r];
				cur[0][1][k][r]%=10000;
			}
			for(int k=8;k>=0;k--){
				cur[1][0][k][r]+=cur[1][0][k+1][r];
				cur[1][0][k][r]%=10000;
				cur[1][1][k][r]+=cur[1][1][k+1][r];
				cur[1][1][k][r]%=10000;
			}
		}
		for(int k=0;k<10;k++){
			int v=(order*k)%M;
			for(int r=0;r<M;r++){
				if(k>0){
					nex[1][0][k][r]=cur[0][0][k-1][(r-v+M)%M];
					if(k<s[i]-'0'){
						nex[1][1][k][r]=nex[1][0][k][r];
					}
					else if (s[i]-'0'==k)
					{
						nex[1][1][k][r]=cur[0][1][k-1][(r-v+M)%M];
					}
					else
					{
						nex[1][1][k][r]=0;
					}
				}
				else
				{
					nex[1][0][k][r]=0;
					nex[1][1][k][r]=0;
				}
				if(k<9){
					nex[0][0][k][r]=cur[1][0][k+1][(r-v+M)%M];
					if(k<s[i]-'0'){
						nex[0][1][k][r]=nex[0][0][k][r];
					}
					else if(s[i]-'0'==k){
						//cout << "aaa " << k << ": " << v << ", " << cur[1][1][k+1][(r-v+M)%M] << endl;
						nex[0][1][k][r]=cur[1][1][k+1][(r-v+M)%M];
					}
					else
					{
						nex[0][1][k][r]=0;
					}
				}
				else
				{
					nex[0][0][k][r]=0;
					nex[0][1][k][r]=0;
				}
			}
		}
		order*=10;
		order%=M;
		swap(cur,nex);
	}
	for(int k=1;k<=s[s.size()-1]-'0';k++){
		//cout << k << ", " << cur[0][1][k][0] << ", " << cur[1][1][k][0] << endl;
		ret+=cur[0][1][k][rem]+cur[1][1][k][rem];
	}
	if(s.size()==1){
		ret/=2;
	}
	ret%=10000;
	return ret;
}
int num2(string a, int rem){
	reverse(a.begin(),a.end());
	istringstream istr(a);
	int v;
	istr >> v;
	int ret=0;
	for(int i=rem;i<=v;i+=M){
		if(i==0)continue;
		ostringstream ostr;
		ostr << i;
		string str=ostr.str();
		if(str.size()==1){
			ret++;
			continue;
		}
		if(str.size()==2){
			if(str[0]!=str[1]){
				ret++;
			}
			continue;
		}
		ret++;
		for(int i=1;i<str.size()-1;i++){
			if((str[i]-str[i-1])*(str[i+1]-str[i])>=0)
			{
				ret--;
				break;
			}
		}
	}
	return ret;
}
bool isZigZag(string s){
	int v=0;
	int b=1;
	for(int i=0;i<s.size();i++){
		v+=b*s[i];
		v%=M;
		b*=10;
		b%=M;
	}
	if(v!=0)return false;
	if(s.size()==1){
		return true;
	}
	if(s.size()==2){
		return s[0]!=s[1];
	}
	for(int i=1;i+1<s.size();i++)
	{
		if((s[i]-s[i-1])*(s[i+1]-s[i])>=0){
			return false;
		}
	}
	return true;
}

int main() {
	string a,b;
#if 0
	int m;
	cin >> a >> M >> m;
	reverse(a.begin(),a.end());
	cout << num(a,m) << ", " << num2(a,m) << endl;
	return 0;
#else
	cin >> a >> b >> M;
	reverse(a.begin(),a.end());
	reverse(b.begin(),b.end());
	int v=num(b,0)-num(a,0);
	if(isZigZag(a)){
		v++;
	}
	cout << (10000+v)%10000 << endl;
#endif
}