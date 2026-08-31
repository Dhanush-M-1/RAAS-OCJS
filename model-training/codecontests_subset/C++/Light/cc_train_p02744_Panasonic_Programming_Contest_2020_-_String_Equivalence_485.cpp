#include <iostream>
#include <string>

using namespace std;

int n;

void dfs(string s, char t);

int main(void)
{
	cin >> n;

	string s = "";
	dfs(s, 'a');

	return 0;
}

void dfs(string s, char t)
{
	if (n == s.length()) {
		cout << s << endl;
	}
	else {
		for (char c = 'a'; c <= t; c++) {
			dfs(s + c, (c == t) ? t + 1 : t);
		}
	}
}