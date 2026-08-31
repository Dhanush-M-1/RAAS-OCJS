#include <iostream>
#include <vector>
#include <algorithm>	// require sort next_permutation etc.
//#include <fstream>	// require freopen

using namespace std;

int main()
{
//	cut here before submit 
//	freopen ("testcase.bb", "r", stdin );
	int n, m;

	while (cin >> n && n ){
		vector <int> a(n);
		int res = 0;
		int i,j;

		for (i = 0; i < n; ++i ) {
			cin >> a[i];
		} // /end for
		for (i = 0; i < n; ++i ) {
			for (j = 0; j < n - i - 1; ++j ) {
				if (a[j] > a[j+1] ) {
					swap (a[j], a[j+1] );
					++res;
				} // end for
 			} // end for
		} // end for
		cout << res << endl;
	} // end loop

	return 0;
}