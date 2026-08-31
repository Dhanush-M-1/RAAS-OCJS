#include<iostream>
#include<algorithm>
#include<utility>


using namespace std;

int main() {
	int n, a[100],count=0;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> a[i];
	for (int i = 0; i < n; i++) {
		int MIN = i;
		for (int j = i; j < n; j++) {
			if (a[j] < a[MIN]) {
				MIN = j;
			}
		}
		if (i != MIN) {
			swap(a[i], a[MIN]);
			count++;
		}
	}
	for (int i = 0; i < n; i++) {
		if (i != 0)cout << " ";
		cout << a[i];
	}
	cout << endl << count << endl;
	return 0;
}