#include<iostream>
using namespace std;
#include<vector>
#include<algorithm>
#include<functional>
#include<iterator>
int main()
{
	vector<int> operate;
	for (int i = 0; i < 200001; i++)
	{
		if (i < 9)
			operate.push_back(2);
		if (i == 9)
			operate.push_back(3);
		if (i > 9)
			operate.push_back((operate[i - 9] + operate[i - 10]) % 1000000007);
	}
	int t;
	cin >> t;
	vector<int> answer;
	for (int i = 0; i < t; i++)
	{
		int n, m;
		cin >> n >> m;
		answer.push_back(0);
		while (n)
		{
			if (m - 10 + n % 10 >= 0)
			{
				answer[i] += operate[m - 10 + n % 10];
			}
			else
				answer[i] += 1;
			answer[i] %= 1000000007;
			n /= 10;
		}
		
	}
	copy(answer.begin(), answer.end(), ostream_iterator<int>(cout, "\n"));
	return 0;
}