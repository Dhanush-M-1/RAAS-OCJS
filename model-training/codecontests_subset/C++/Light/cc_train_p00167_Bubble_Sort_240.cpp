#include <bits/stdc++.h>

using namespace std;


int BubbleData[100];

void judge(const int n) {
	int cnt,tmp;

	cnt = 0;
	for (int i = n; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (BubbleData[j] > BubbleData[j + 1]) {
				cnt++;
				tmp = BubbleData[j];
				BubbleData[j] = BubbleData[j + 1];
				BubbleData[j + 1] = tmp;
			}
		}
	}
	cout << cnt << endl;
}


int main(void) {
	int n;

	while (cin >> n, n) {
		for (int i = 0; i < n; i++) {
			cin >> BubbleData[i];
		}
		judge(n-1);
	}

	return 0;
}
