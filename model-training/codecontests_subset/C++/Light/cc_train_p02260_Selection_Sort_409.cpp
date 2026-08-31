#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n,a[100],cnt = 0;
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> a[i];

	for(int i = 0; i < n - 1; i++){
		int min = a[i], ret = i;
		for(int j = i + 1; j < n; j++){
			if(min > a[j]){
				min = a[j]; ret = j;
			}
		}
		if(ret != i) {
			int z = a[i]; a[i] = a[ret]; a[ret] = z;
			cnt++;
		}
	}

	for(int i = 0; i < n - 1 ; i++)
		cout << a[i] <<" ";
	cout << a[n-1] << endl;
	cout << cnt << endl;
}