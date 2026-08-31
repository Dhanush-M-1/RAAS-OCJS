#include <bits/stdc++.h>
#define MOD ((int)1e9+7)

using namespace std;

int mem[100005],br[100005];
int n,m;

int go(int x)
{
	if(x==n) return 1;
	if(x>n||br[x]) return 0;
	if(mem[x]!=-1) return mem[x];
	return mem[x]=(go(x+1)+go(x+2))%MOD;
}

int main()
{
	cin >> n >> m;
	for(int i=0;i<m;i++)
	{
		int x; cin >> x;
		br[x]=1;
	}
	memset(mem,-1,sizeof mem);
	cout << go(0) << endl;
}