#include<bits/stdc++.h>
#define rep(i,n)for(int i=0;i<n;i++)
using namespace std;
typedef long long ll;

int a[100];
int main() {
	int n;
	while (cin >> n, n) {
		rep(i, n)scanf("%d", &a[i]);
		int cnt = 0;
		bool flag = true;
		for (int i = 0; flag; i++) {
			flag = false;
			for (int j = n - 1; j >= i + 1; j--) {
				if (a[j] < a[j - 1]) {
					swap(a[j], a[j - 1]);
					flag = true;
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}
}