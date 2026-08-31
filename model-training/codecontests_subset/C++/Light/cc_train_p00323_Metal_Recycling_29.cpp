// なにこれ
// なにこれと言いながらシミュレーションすると解けます

#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int>v(300000);
	for (int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		v[a + b] ++;
	}
	for (int i = 0; i < 250000; i++) {
		v[i + 1] += v[i] / 2;
		v[i] %= 2;
		if (v[i] > 0) cout << i << " " << 0 << endl;
	}
}
