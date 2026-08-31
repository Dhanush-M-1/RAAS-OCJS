#include <iostream>
#include <map>

using namespace std;

int main(){
	map<char, bool[13]> trump;
	int n;

	cin >> n;
	for(int i = 0; i < n; i++){
		char d;
		int r;

		cin >> d >> r;
		trump[d][r-1] = true;
	}

	for(auto d : {'S', 'H', 'C', 'D'})
		for(int i = 0; i < sizeof(trump[d]); i++)
			if(!trump[d][i])
				cout << d << " " << i+1 << endl;
}

