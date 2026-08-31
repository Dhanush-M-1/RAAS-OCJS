#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <cmath>
using namespace std;

vector<string> split(const string &str, char delim){
  vector<string> res;
  size_t current = 0, found;
  while((found = str.find_first_of(delim, current)) != string::npos){
    res.push_back(string(str, current, found - current));
    current = found + 1;
  }
  res.push_back(string(str, current, str.size() - current));
  return res;
}

double isCross(double p1_x,double p1_y,double p2_x,double p2_y,double p3_x,double p3_y,double p4_x,double p4_y){  
    return ( (p1_x-p2_x)*(p3_y-p1_y) + (p1_y-p2_y)*(p1_x-p3_x)) * ((p1_x-p2_x)*(p4_y-p1_y) + (p1_y-p2_y)*(p1_x-p4_x));  
}




int main()
{
	string s;
	while(cin >> s)
	{
		vector<string> _s = split(s,',');
		double *a = new double[8];
		for(int i=0;i<8;i++)
		{
			a[i] = atoi(_s[i].c_str());
		}

		if(isCross(a[0],a[1],a[4],a[5],a[2],a[3],a[6],a[7]) > 0.0 || isCross(a[2],a[3],a[6],a[7],a[0],a[1],a[4],a[5]) > 0.0)
		{
			cout << "NO" << endl; 
		}
		else
		{
			cout << "YES" << endl;
		}
	}

	return 0;
}