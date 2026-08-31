#include<iostream>
#include<vector>
#include<string>
using namespace std;


vector<string> goku;

int checkKu(int bgn, int chlen) {
	int len = 0;
	int i = 0;
	while (1) {
		len += goku[bgn+i].size();
		i+=1;
		if (len > chlen)return -1;
		else if (len == chlen)return i;
	}
}

bool solve(int start) {
	int Ku[5] = { 5,7,5,7,7 }, k = start;
	for (int i = 0; i < 5; i++) {
		int j = checkKu(k, Ku[i]);
		//cout << j << endl;
		if (j > 0)k += j;
		else return false;
	}
	return true;
}

int main() {

	while (1) {
		int n;
		goku.clear();
		cin >> n;
		if (n == 0)break;
		//input
		for (int i = 0; i < n; i++) {
			string str;
			cin >> str;
			goku.push_back(str);
		}

		int s = 0;
		while (1) {
			if (solve(s))break;
			else s++;
		}
		cout << s + 1 << endl;
	}
	return 0;
}