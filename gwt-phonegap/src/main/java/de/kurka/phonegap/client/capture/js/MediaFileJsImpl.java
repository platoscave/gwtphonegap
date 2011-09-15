package de.kurka.phonegap.client.capture.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.capture.MediaFile;
import de.kurka.phonegap.client.capture.MediaFormatDataCallback;

public final class MediaFileJsImpl extends JavaScriptObject implements MediaFile {

	protected MediaFileJsImpl() {

	}

	@Override
	public native String getName() /*-{
		return this.name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return this.fullPath;
	}-*/;

	@Override
	public native String getType()/*-{
		return this.type;
	}-*/;

	@Override
	public native Date getLastModifiedDate() /*-{
		return @de.kurka.phonegap.client.capture.js.MediaFileJsImpl::createDate(D)(this.lastModifiedDate.getTime());
	}-*/;

	public static Date createDate(double time) {
		return new Date(Math.round(time));
	}

	@Override
	public long getSize() {
		return Math.round(getSize0());
	}

	private native double getSize0()/*-{
		return this.size;
	}-*/;

	@Override
	public native void getFormatData(MediaFormatDataCallback callback) /*-{

		var suc = function(data) {
			callback.@de.kurka.phonegap.client.capture.MediaFormatDataCallback::onSuccess(Lde/kurka/phonegap/client/capture/MediaFileData;)(data);
		};

		var fail = function() {
			callback.@de.kurka.phonegap.client.capture.MediaFormatDataCallback::onFailure()();
		};

		this.getFormatData($entry(suc), $entry(fail));

	}-*/;

}
