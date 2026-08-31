#include <iostream>
#include <algorithm>
using namespace std;

int solve(int x)
{
	int num = x;
	int count = 0;

	while (num / 10 != 0) {
		int maxx = 0;
		for (int i = 1; num / i != 0; i *= 10) {
			int temp1 = num / i;
			int temp2 = num%i;

			maxx = max(maxx, temp1*temp2);
		}
		num = maxx;
		count++;
	}

	return count;
}

int main()
{
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;

		cout << solve(x) << endl;
	}

	return 0;
}