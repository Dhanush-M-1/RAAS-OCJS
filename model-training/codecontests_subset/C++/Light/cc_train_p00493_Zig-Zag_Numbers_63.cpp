#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <complex>
#include <string>
#include <sstream>
#include <algorithm>
#include <vector>
#include <queue>
#include <stack>
#include <functional>
#include <iostream>
#include <map>
#include <set>
using namespace std;
typedef pair<int,int> P;
typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vll;
#define pu push
#define pb push_back
#define mp make_pair
#define eps 1e-9
#define INF 2000000000
#define sz(x) ((int)(x).size())
#define fi first
#define sec second
#define SORT(x) sort((x).begin(),(x).end())
#define all(x) (x).begin(),(x).end()
#define EQ(a,b) (abs((a)-(b))<EPS)
#define MOD 10000
int dp[505][10][505][3][2];
int M;
vector<int> a,b;
int rec(vector<int> &vec,int index,int prev,int mod,int upper,bool free)
{
	if(index==vec.size())return (mod?0:1);
	if(dp[index][prev][mod][upper][free]>0)return dp[index][prev][mod][upper][free];
	int can;
	if(free){can=9;}
	else {can=vec[index];}
	int res=0;
	for(int i=0;i<=can;i++)
	{
		res%=MOD;
		if(upper==0&&prev>=i)continue;
		if(upper==1&&prev<=i)continue;
		if(upper==2&&prev&&prev==i)continue;
		int new_upper;
		if(upper==2)
		{
			if(prev==0)new_upper=2;
			else if(prev<i)new_upper=1;
			else new_upper=0;
		}
		else new_upper=!upper;
		res += rec(vec,index+1,i,(mod*10+i)%M,new_upper,free|(i!=vec[index]));
	}
	return dp[index][prev][mod][upper][free]=res%MOD;
}
int main()
{
	string s1,s2;
	cin >> s1;
	cin >> s2;
	cin >> M;
	for(int i=0;i<s1.size();i++)a.pb(s1[i]-'0');
	for(int i=0;i<s2.size();i++)b.pb(s2[i]-'0');
	for(int i=a.size()-1;i>=0;i--)
	{
		if(a[i]==0)a[i]=9;
		else
		{
			a[i]--;
			break;
		}
	}
	memset(dp,-1,sizeof(dp));
	int A=rec(a,0,0,0,2,false);
	memset(dp,-1,sizeof(dp));
	int B=rec(b,0,0,0,2,false);
	int ans=(B-A+MOD)%MOD;
	//cout << A << ' ' << B <<endl; 
	cout << ans << endl;
	return 0;
}