#include <bits/stdc++.h>

using namespace std;


int main() {

	int N, M,tmp;
	const int at = pow(10,9)+7;
	cin >> N >> M;
	vector<int>dp(N+1),br(N+1,1);
	for (size_t i = 0; i < M; i++)
	{
		cin >> tmp;
		br.at(tmp) = 0;
	}
	dp.at(0) = 1;
	dp.at(1) = 1 * br.at(1);
	for (size_t i = 2; i < N+1; i++)
	{
		dp.at(i) = (dp.at(i - 2) % at + dp.at(i - 1) % at)%at * br.at(i);
	}
	cout << dp.at(N);
}
