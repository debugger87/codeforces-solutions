#include <iostream>
#include <string>

using namespace std;

int absInt(int x) {
	if (x >= 0) {
		return x;
	} else {
		return -x;
	}
}

int main() {
	string s;
	string t;
	cin>>s;
	cin>>t;
	int sx = s[0] - 'a' + 1;
	int sy = s[1] - '0';
	int tx = t[0] - 'a' + 1;
	int ty = t[1] - '0';
	cout<<max(absInt(tx-sx), absInt(ty-sy))<<endl;
	while(sx != tx || sy != ty) {
		if (sx < tx) {
			++sx;
			cout<<'R';
		}
		if (sx > tx) {
			--sx;
			cout<<'L';
		}
		if (sy < ty) {
			++sy;
			cout<<'U';
		}
		if (sy > ty) {
			--sy;
			cout<<'D';
		}
		cout<<endl;
	}
	return 0;
}
