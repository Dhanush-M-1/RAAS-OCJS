#include <iostream>
#include <string>
using namespace std;

int N;

void dfs(char a = 'a', string b = "") {
	if (b.size() == N) cout << b << endl;
	else {
		for (char i = 'a'; i < a; i++) dfs(a, b + i);
		dfs(a + 1, b + a);
	}
}

int main() {
	cin >> N;
	dfs();
}