#include <bits/stdc++.h>
using namespace std;
const int mod = 10000;
#define rep(i,n) for(int i = 0;i < n;i++)
#define rrep(i,n) for(int i = 1;i <= n;i++)

string s;
int dp[502][2][3][10][500], m;
//dp[桁][使えるか][上下][前の数字][mod]
int rec(int p, int ok, int pre_up, int pre, int num){
	if(p == s.size())return (num == 0);
	if(dp[p][ok][pre_up][pre][num] != -1)return dp[p][ok][pre_up][pre][num];
	
	int n = ok ? 9 : s[p]-'0';
	int res = 0;
	for(int i = 0;i <= n;i++){
		if(pre_up == 1 && pre <= i)continue;
		if(pre_up == 2 && pre >= i)continue;
		if(pre_up == 0){
			if(pre == 0)res += rec(p+1, ok|(i < n), 0, i, (num*10+i)%m);
			else if(pre < i)res += rec(p+1, ok|(i < n), 1, i, (num*10+i)%m);
			else if(pre > i)res += rec(p+1, ok|(i < n), 2, i, (num*10+i)%m);
		}else if(pre_up == 1){
			res += rec(p+1, ok|(i < n), 2, i, (num*10+i)%m);
		}else{
			res += rec(p+1, ok|(i < n), 1, i, (num*10+i)%m);
		}
	}
	
	return dp[p][ok][pre_up][pre][num] = res % mod;
}

int get(string str){
	s = str;
	fill((int*)dp, (int*)(dp+502), -1);
	int ans = rec(0, 0, 0, 0, 0);
	return ans;
}

string calc(string str){
	for(int i = str.size()-1;i >= 0;i--){
		if(str[i] == '0')str[i] = '9';
		else {str[i]--;break;}
	}
	return str;
}

int main(){
	string a, b;
	cin >> a >> b >> m;
	int ans = (get(b)-get(calc(a)) + mod)%mod;
	printf("%d\n", ans);
	return 0;
}
