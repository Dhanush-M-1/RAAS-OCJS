#include <algorithm>
#include <iomanip>
#include <iostream>
using namespace std;
/** Problem0167 : Bubble Sort **/
int main()
{
	int d[100], n, ans;
	
	while (cin >> n, n!= 0) {
		ans=0;
		
		for (int i=0; i<n; i++)
			cin >> d[i];
	
		for (int i=0; i<n; i++) {
			for (int j=n-1; i<j; j--) {
				if (d[j-1] > d[j]) {
					swap(d[j-1], d[j]);
					ans++;
				}
			}
		}
	
		cout << ans << endl;
	}
}