#include<bits/stdc++.h>
using namespace std;
#define long long long 
#define fi first
#define se second
const long MOD = 1e9+7;
const long LINF = 1e18;
const long INF = 1e9;

typedef pair<int,int> ii;
typedef pair<int,ii> iii;

int D[10][200003][10];

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	// freopen("input.in", "r", stdin);

	for(int i = 0; i < 10; i++)
		D[i][0][i] = 1;
	for(int i = 0; i < 10; i++)
	{
		for(int j = 0; j <= 199999; j++)
		{
			for(int k = 0; k <= 8; k++)
				D[i][j+1][k+1] = (D[i][j+1][k+1]+D[i][j][k])%MOD;
			D[i][j+1][1] = (D[i][j+1][1]+D[i][j][9])%MOD;
			D[i][j+1][0] = (D[i][j+1][0]+D[i][j][9])%MOD;
		}
	}
	int t; cin >> t;
	while(t--)
	{
		string s; cin >> s;
		int k; cin >> k;
		int res = 0;
		for(char c : s)
		{
			int x = c-'0';
			for(int i = 0; i <= 9; i++)
				res = (res+D[x][k][i])%MOD;
		}
		cout << res << "\n";
	}
}