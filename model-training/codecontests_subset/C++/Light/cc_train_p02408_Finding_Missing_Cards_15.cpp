#include <iostream>
#include <vector>
using namespace std;

int main(){
	int n;
	cin >> n;
	vector<vector<bool>> v(4, vector<bool>(13));
	while(n--){
		char c;
		int a;
		cin >> c >> a;
		int index = c == 'S' ? 0 : c == 'H' ? 1 : c == 'C' ? 2 : 3;
		v[index][--a] = true;
	}
	for(int i = 0; i < 4; i++) for(int j = 0; j < 13; j++) if(!v[i][j]) cout << "SHCD"[i] << ' ' << j + 1 << endl;
}