#include<iostream>
#include<vector>
using namespace std;
int main() {
	vector<int> line(200020, 0);
	int N;
	cin >> N;
	for (int i = 0; i < N; ++i) {
		int a, b;
		cin >> a >> b;
		++line[a + b];
	}
	for (int i = 0; i < line.size()-1; ++i) {
		line[i + 1] += line[i] / 2;
		line[i] %= 2;
		if (line[i]) {
			cout << i << " " << 0 << endl;
		}
	}
	return 0;
}