#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <list>
using namespace std;
#define REP(i,x,n) for(int i = x; i < n; i++)

bool solve() {

	int n; cin >> n;
	if (n == 0)return false;

	vector<string> w(n);
	REP(i, 0, n)cin >> w[i];

	REP(i, 0, n)
	{
		list<int> mojisu{5,7,5,7,7};
		REP(j, i, n)
		{
			mojisu.front()-=w[j].length();
			if (mojisu.front() == 0)
			{
				mojisu.pop_front();
				if (mojisu.empty())
				{
					cout << i + 1 << endl;
					return true;
				}
			}
			else if(mojisu.front() < 0)
			{
				break;
			}
		}
	}
}

signed main() {
	while (solve()) {
	}
	return 0;
}

