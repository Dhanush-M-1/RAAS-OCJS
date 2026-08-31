#include <iostream>
using namespace std;

#define rep(i,n) for(int i=0;i<(int)n;++i)

int N;

void dfs(string s, char mx)
{
	if (s.size() == N) {
		cout << s << endl;
		return;
	}

	for (char c = 'a'; c <= mx + 1; ++c) {
		dfs(s + c, c > mx ? c : mx);
	}
}

int main()
{
	cin >> N;

	dfs("", 'a'-1);
}
