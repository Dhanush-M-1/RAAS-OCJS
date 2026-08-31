#include <bits/stdc++.h>

using namespace std;

#define FOR(i,k,n) for(int i = (k); i < (n); i++)
#define REP(i,n) FOR(i,0,n)
#define INF 114514810
#define ELEM(array) (sizeof (array)/sizeof *(array))
#define MAX_N 100
#define SAFE_FREE(ptr) if( ptr != NULL ){ free(ptr); ptr = NULL; }
typedef unsigned int UINT;
typedef long long ll;

int main()
{
	int n, a[1005];
	while (1)
	{
		cin >> n; if (n == 0){ break; }
		REP(i, n)cin >> a[i];
		int cnt = 0;
		REP(i, n - 1)REP(j, n - 1)
		{
			if (a[j]>a[j+1])
			{
				swap(a[j], a[j + 1]);
				cnt++;
			}
		}
		cout << cnt << endl;
	}
}